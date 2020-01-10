package com.zfy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

public class Ntmd {

    public static void main(String[] args) {
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress("47.92.194.200", 27017);
        List<ServerAddress> addrs = new ArrayList<>();
        addrs.add(serverAddress);
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential("ntmd", "ntmd", "XQTY$nTmD&888".toCharArray());
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(credential);
        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs, credentials);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ntmd");
        MongoCollection<Document> collection = mongoDatabase.getCollection("testinghistories");
        //查询过程
        BasicDBObject query = new BasicDBObject();
        //查询条件
        query.put("Detection_Id", "75403274ac8b4af68b703119f3cfc0b9");
        //查询结果
        MongoCursor<Document> cursor = collection.find(query).skip(0).iterator();
        String reportData;
        ReportDataModel reportDataModel;
        ReportDataModel.BodyScoresAromBean bodyScoresAromBean;

        while (cursor.hasNext()) {
            Document document = cursor.next();
            List motions = (List) document.get("motions");
            System.out.println(motions);
            JSONArray objects = JSON.parseArray(JSON.toJSONString(motions.toArray()));
            System.out.println(objects);
            try {
                reportData = objects.getJSONObject(0).getString("reportData");
                JSONObject parse = (JSONObject) JSONObject.parse(reportData);
                ExportByBodyarom(parse);
                ExportByBodystability(parse);
                ExportBodysymmetry(parse);
                System.out.println("a\\b\\c");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * body_scores_symmetry
     * @param parse
     */
    private static void ExportBodysymmetry(JSONObject parse) throws IOException{
        JSONObject body_scores_symmetry = parse.getJSONObject("body_scores_symmetry");
//        Set<String> strings = body_scores_symmetry.keySet();
        ArrayList<Object> list = new ArrayList<>(body_scores_symmetry.values());
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<String> strings1 = new ArrayList<>(body_scores_symmetry.keySet());
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < strings1.size(); j++) {
                if(i==j){
                    map.put(strings1.get(i),list.get(i));
                }
            }
            System.out.println();
        }
        String fileName1 = "E:\\c.xls";
        String title1 = "body_scores_symmetry";
        String[] heders1 = {
                "score_neck",
                "score_shoulder",
                "score_torso",
                "score_hip",
                "score_knee"};
        String pattern1 = null;
        List<Map> list1 = new ArrayList<>();
        list1.add(map);
        boolean flag = exportExcel(fileName1,title1,heders1,list1,pattern1);

        System.out.println("flag===="+flag+"/"+fileName1);

    }

    /**
     * 导出body_scores_stability得分
     * @param parse
     * @throws IOException
     */
    private static void ExportByBodystability(JSONObject parse) throws IOException{

        JSONObject body_scores_stability = parse.getJSONObject("body_scores_stability");
//        Set<String> str2 = body_scores_stability.keySet();
        ArrayList<Object> obj1 = new ArrayList<>(body_scores_stability.values());
        HashMap<Object, Object> map1 = new HashMap<>();
        ArrayList<String> strs2 = new ArrayList<>(body_scores_stability.keySet());
        for (int i = 0; i < obj1.size(); i++) {
            for (int j = 0; j < strs2.size(); j++) {
                if (i == j) {
                    map1.put(strs2.get(i), obj1.get(j));
                }
            }
        }
        String fileName1 = "E:\\b.xls";
        String title1 = "body_scores_stability";
        String[] heders1 = {
                "score_neck","score_neck_L","score_neck_R",
                "score_shoulder_L","score_shoulder_R",
                "score_torso","score_torso_L","score_torso_R",
                "score_hip_L","score_hip_R",
                "score_knee_L","score_knee_R",};
        String pattern1 = null;
        List<Map> list1 = new ArrayList<>();
        list1.add(map1);
        boolean flag = exportExcel(fileName1,title1,heders1,list1,pattern1);
        System.out.println("flag===="+flag+"/"+fileName1);
    }


    /**
     * 导出body_scores_arom得分
     * @param parse
     * @throws IOException
     */
    private static void ExportByBodyarom(JSONObject parse) throws IOException{

        JSONObject body_scores_arom = parse.getJSONObject("body_scores_arom");
//        Set<String> strings1 = body_scores_arom.keySet();
        ArrayList<Object> objects1 = new ArrayList<>(body_scores_arom.values());
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<String> strings2 = new ArrayList<>(body_scores_arom.keySet());
        for (int i = 0; i < objects1.size(); i++) {
            for (int j = 0; j < strings2.size(); j++) {
                if (i == j) {
                    map.put(strings2.get(i), objects1.get(j));
                }
            }
        }
        String fileName = "E:\\a.xls";
        String title = "body_scores_arom";
        String[] heders = {"score_neck",
                "score_shoulder_L","score_shoulder_R",
                "score_torso",
                "score_hip_L","score_hip_R",
                "score_hip_L","score_hip_R",};
        String pattern=null;
        List<Map> list = new ArrayList<>();
        list.add(map);
        boolean flag = exportExcel(fileName,title,heders,list,pattern);
        System.out.println("flag===="+flag+"/"+fileName);
    }

    private static boolean exportExcel(String fileName, String title, String[] heders, List<Map> data, String pattern) {
       boolean flag =false;
        Workbook workbook = null;
        if (fileName.endsWith("xls")) {
            workbook = new XSSFWorkbook();
        } else if (fileName.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else {
            try {
                throw new Exception("Excel格式不正确！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Sheet sheet = workbook.createSheet(title);
        CellStyle cellStyle = workbook.createCellStyle();
        //创建列明
        Row row = sheet.createRow(0);
        for (int i = 0; i < heders.length; i++) {
            Cell cell = row.createCell(i);
            sheet.setColumnWidth(i,5000);
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            cell.setCellValue(heders[i]);
        }
        Iterator<Map> it = data.iterator();
        int index = 0;
        while (it.hasNext()){
            index++;
            row = sheet.createRow(index);
            Map map = it.next();
            Set<String> mapSet = (Set<String>) map.keySet();
            Iterator<String> iterator = mapSet.iterator();
            int num = 0;
            while (iterator.hasNext()){
                Cell cell = row.createCell(num);
                num++;
                String next = iterator.next();
                Object o = map.get(next);
                if (o instanceof Date){
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    cell.setCellValue(sdf.format(o));
                }else if(o instanceof Integer){
                    cell.setCellValue((Integer) o);
                }else if(o instanceof Double){
                    cell.setCellValue((Double) o);
                }else {
                    cell.setCellValue((String) o);
                }
            }
        }

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
            flag =true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("导出失败");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写入错误");
            flag = false;
    }
        return flag;

    }

}
