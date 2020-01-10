package com.zfy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.bson.Document;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress("47.92.194.200", 27017);
        List<ServerAddress> addrs = new ArrayList<>();
        addrs.add(serverAddress);
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential("ntsports", "ntmd_add", "NTS&Gm$888".toCharArray());
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(credential);
        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs, credentials);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ntmd_add");
        MongoCollection<Document> collection = mongoDatabase.getCollection("testing_data");
        //查询过程
        BasicDBObject query = new BasicDBObject();
        //查询条件deef4314ec304ea4a78d614d8fcff59e
        //127d4dcc620b44429c77b2ea6a6628a5
        query.put("detectionID", "92dbaf3b6ed44d5ea815b3ad14eabd7b");
        //查询结果
        MongoCursor<Document> cursor = collection.find(query).skip(0).iterator();
        if (cursor.hasNext()) {
            Document document = cursor.next();
            Document jointValue = (Document) document.get("jointValue");
            Set<String> strings = jointValue.keySet();
            CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("ActID", "#", "Joints",
                    "v_最大值", "v_最小值", "v_初始值",
                    "x_最大值", "x_最小值", "x_初始值",
                    "y_最大值", "y_最小值", "y_初始值",
                    "z_最大值", "z_最小值", "z_初始值");
            FileOutputStream fos = new FileOutputStream("E://动作关节点过程参考值.csv");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
            CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);
            List<String> list = writeJointValue(jointValue, strings, csvPrinter);
            System.out.println("输出jointValue成功，输出地址：E://动作关节点过程参考值.csv");

            JSONArray indexValues = JSON.parseArray(JSON.toJSONString(((Document) document.get("indexValue")).values().toArray()));
            JSONArray indexScores = JSON.parseArray(JSON.toJSONString(((Document) document.get("indexScore")).values().toArray()));

            Document indexScoreFinal = ((Document) document.get("indexScoreFinal"));
            FileOutputStream fos1 = new FileOutputStream("E://动作指标计算值和评价值.csv");
            OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "GBK");
            StringBuilder stringBuilder = new StringBuilder("#,");
            for (String item : list) {
                stringBuilder.append(item).append("-指标取值,");
                stringBuilder.append(item).append("-评价结果,");
            }
            stringBuilder.append("综合得分-指标取值,");
            stringBuilder.append("综合得分-评价结果");
            CSVFormat csvFormat1 = CSVFormat.DEFAULT.withHeader(stringBuilder.toString().split(","));
            CSVPrinter csvPrinter1 = new CSVPrinter(osw1, csvFormat1);
            wirteIndexValue(list, indexValues, indexScores, indexScoreFinal, csvPrinter1);
            System.out.println("输出indexValue成功，输出地址：E://动作指标计算值和评价值.csv");
        }
    }

    private static void wirteIndexValue(List<String> list, JSONArray indexValues, JSONArray indexScores, Document indexScoreFinal, CSVPrinter csvPrinter1) throws IOException {
        // 列
        Set<String> strings1 = indexScoreFinal.keySet();
        int size = list.size();
        // key首列，一个对象占两个，综合站两个
        Object[] objects = new Object[1 + size * 2 + 2];
        for (String item : strings1) {
            int flag = 0;
            objects[flag] = item;
            flag++;
            for (int i = 0; i < size; i++) {
                objects[flag] = indexValues.getJSONObject(i).get(item);
                objects[flag + 1] = indexScores.getJSONObject(i).get(item);
                flag += 2;
            }
            objects[flag + 1] = indexScoreFinal.get(item);
            csvPrinter1.printRecord(objects);
        }
        csvPrinter1.flush();
        csvPrinter1.close();
    }

    private static List<String> writeJointValue(Document jointValue, Set<String> strings, CSVPrinter csvPrinter) throws IOException {
        // 存储ActID
        List<String> list = new LinkedList<>();
        JointValueModel parse;
        JointValueModel.VBeanX v;
        JointValueModel.XBean x;
        JointValueModel.YBean y;
        JointValueModel.ZBean z;
        for (String item : strings) {
            list.add(item);
            int flag = 0;
            Document jointValueDocument = (Document) jointValue.get(item);
            Set<String> strings1 = jointValueDocument.keySet();
            for (String item2 : strings1) {
                Object o = jointValueDocument.get(item2);
                if (o instanceof Document) {
                    parse = JSON.parseObject(((Document) o).toJson(), JointValueModel.class);
                    v = parse.getV();
                    x = parse.getX();
                    y = parse.getY();
                    z = parse.getZ();
                    csvPrinter.printRecord(item, item2, Contant.JOINTS[flag],
                            v.getVMax(), v.getVMin(), v.getSMin(),
                            x.getVMax(), x.getVMin(), x.getSMin(),
                            y.getVMax(), y.getVMin(), y.getSMin(),
                            z.getVMax(), z.getVMin(), z.getSMin());
                    flag++;
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
        return list;
    }
}
