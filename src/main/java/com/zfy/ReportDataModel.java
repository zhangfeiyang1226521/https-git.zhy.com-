package com.zfy;

public class ReportDataModel {

    /**
     * score_overall : 69
     * score_symmetry : 55
     * score_stability : 77
     * score_arom : 80
     * visit_time : 2020-0-3 8:37:3
     * body_scores_symmetry : {"score_knee":34,"score_hip":35,"score_torso":93,"score_shoulder":57,"score_neck":56}
     * body_scores_stability : {"score_knee_left":24,"score_knee_right":0,"score_hip_left":91,"score_hip_right":90,"score_torso_right":91,"score_torso_left":83,"score_torso":174,"score_shoulder_left":65,"score_shoulder_right":27,"score_neck_right":91,"score_neck_left":69,"score_neck":160}
     * body_scores_arom : {"score_knee_left":86,"score_knee_right":78,"score_hip_left":67,"score_hip_right":88,"score_torso":-9999,"score_shoulder_left":74,"score_shoulder_right":86,"score_neck":-9999}
     */

    private Double score_overall;
    private Double score_symmetry;
    private Double score_stability;
    private Double score_arom;
    private String visit_time;
    private BodyScoresSymmetryBean body_scores_symmetry;
    private BodyScoresStabilityBean body_scores_stability;
    private BodyScoresAromBean body_scores_arom;

    public Double getScore_overall() {
        return score_overall;
    }

    public void setScore_overall(Double score_overall) {
        this.score_overall = score_overall;
    }

    public Double getScore_symmetry() {
        return score_symmetry;
    }

    public void setScore_symmetry(Double score_symmetry) {
        this.score_symmetry = score_symmetry;
    }

    public Double getScore_stability() {
        return score_stability;
    }

    public void setScore_stability(Double score_stability) {
        this.score_stability = score_stability;
    }

    public Double getScore_arom() {
        return score_arom;
    }

    public void setScore_arom(Double score_arom) {
        this.score_arom = score_arom;
    }

    public String getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(String visit_time) {
        this.visit_time = visit_time;
    }

    public BodyScoresSymmetryBean getBody_scores_symmetry() {
        return body_scores_symmetry;
    }

    public void setBody_scores_symmetry(BodyScoresSymmetryBean body_scores_symmetry) {
        this.body_scores_symmetry = body_scores_symmetry;
    }

    public BodyScoresStabilityBean getBody_scores_stability() {
        return body_scores_stability;
    }

    public void setBody_scores_stability(BodyScoresStabilityBean body_scores_stability) {
        this.body_scores_stability = body_scores_stability;
    }

    public BodyScoresAromBean getBody_scores_arom() {
        return body_scores_arom;
    }

    public void setBody_scores_arom(BodyScoresAromBean body_scores_arom) {
        this.body_scores_arom = body_scores_arom;
    }

    public static class BodyScoresSymmetryBean {
        /**
         * score_knee : 34
         * score_hip : 35
         * score_torso : 93
         * score_shoulder : 57
         * score_neck : 56
         */

        private Double score_knee;
        private Double score_hip;
        private Double score_torso;
        private Double score_shoulder;
        private Double score_neck;

        public Double getScore_knee() {
            return score_knee;
        }

        public void setScore_knee(Double score_knee) {
            this.score_knee = score_knee;
        }

        public Double getScore_hip() {
            return score_hip;
        }

        public void setScore_hip(Double score_hip) {
            this.score_hip = score_hip;
        }

        public Double getScore_torso() {
            return score_torso;
        }

        public void setScore_torso(Double score_torso) {
            this.score_torso = score_torso;
        }

        public Double getScore_shoulder() {
            return score_shoulder;
        }

        public void setScore_shoulder(Double score_shoulder) {
            this.score_shoulder = score_shoulder;
        }

        public Double getScore_neck() {
            return score_neck;
        }

        public void setScore_neck(Double score_neck) {
            this.score_neck = score_neck;
        }
    }

    public static class BodyScoresStabilityBean {
        /**
         * score_knee_left : 24
         * score_knee_right : 0
         * score_hip_left : 91
         * score_hip_right : 90
         * score_torso_right : 91
         * score_torso_left : 83
         * score_torso : 174
         * score_shoulder_left : 65
         * score_shoulder_right : 27
         * score_neck_right : 91
         * score_neck_left : 69
         * score_neck : 160
         */

        private Double score_knee_left;
        private Double score_knee_right;
        private Double score_hip_left;
        private Double score_hip_right;
        private Double score_torso_right;
        private Double score_torso_left;
        private Double score_torso;
        private Double score_shoulder_left;
        private Double score_shoulder_right;
        private Double score_neck_right;
        private Double score_neck_left;
        private Double score_neck;

        public Double getScore_knee_left() {
            return score_knee_left;
        }

        public void setScore_knee_left(Double score_knee_left) {
            this.score_knee_left = score_knee_left;
        }

        public Double getScore_knee_right() {
            return score_knee_right;
        }

        public void setScore_knee_right(Double score_knee_right) {
            this.score_knee_right = score_knee_right;
        }

        public Double getScore_hip_left() {
            return score_hip_left;
        }

        public void setScore_hip_left(Double score_hip_left) {
            this.score_hip_left = score_hip_left;
        }

        public Double getScore_hip_right() {
            return score_hip_right;
        }

        public void setScore_hip_right(Double score_hip_right) {
            this.score_hip_right = score_hip_right;
        }

        public Double getScore_torso_right() {
            return score_torso_right;
        }

        public void setScore_torso_right(Double score_torso_right) {
            this.score_torso_right = score_torso_right;
        }

        public Double getScore_torso_left() {
            return score_torso_left;
        }

        public void setScore_torso_left(Double score_torso_left) {
            this.score_torso_left = score_torso_left;
        }

        public Double getScore_torso() {
            return score_torso;
        }

        public void setScore_torso(Double score_torso) {
            this.score_torso = score_torso;
        }

        public Double getScore_shoulder_left() {
            return score_shoulder_left;
        }

        public void setScore_shoulder_left(Double score_shoulder_left) {
            this.score_shoulder_left = score_shoulder_left;
        }

        public Double getScore_shoulder_right() {
            return score_shoulder_right;
        }

        public void setScore_shoulder_right(Double score_shoulder_right) {
            this.score_shoulder_right = score_shoulder_right;
        }

        public Double getScore_neck_right() {
            return score_neck_right;
        }

        public void setScore_neck_right(Double score_neck_right) {
            this.score_neck_right = score_neck_right;
        }

        public Double getScore_neck_left() {
            return score_neck_left;
        }

        public void setScore_neck_left(Double score_neck_left) {
            this.score_neck_left = score_neck_left;
        }

        public Double getScore_neck() {
            return score_neck;
        }

        public void setScore_neck(Double score_neck) {
            this.score_neck = score_neck;
        }
    }

    public static class BodyScoresAromBean {
        /**
         * score_knee_left : 86
         * score_knee_right : 78
         * score_hip_left : 67
         * score_hip_right : 88
         * score_torso : -9999
         * score_shoulder_left : 74
         * score_shoulder_right : 86
         * score_neck : -9999
         */

        private Double score_knee_left;
        private Double score_knee_right;
        private Double score_hip_left;
        private Double score_hip_right;
        private Double score_torso;
        private Double score_shoulder_left;
        private Double score_shoulder_right;
        private Double score_neck;

        public Double getScore_knee_left() {
            return score_knee_left;
        }

        public void setScore_knee_left(Double score_knee_left) {
            this.score_knee_left = score_knee_left;
        }

        public Double getScore_knee_right() {
            return score_knee_right;
        }

        public void setScore_knee_right(Double score_knee_right) {
            this.score_knee_right = score_knee_right;
        }

        public Double getScore_hip_left() {
            return score_hip_left;
        }

        public void setScore_hip_left(Double score_hip_left) {
            this.score_hip_left = score_hip_left;
        }

        public Double getScore_hip_right() {
            return score_hip_right;
        }

        public void setScore_hip_right(Double score_hip_right) {
            this.score_hip_right = score_hip_right;
        }

        public Double getScore_torso() {
            return score_torso;
        }

        public void setScore_torso(Double score_torso) {
            this.score_torso = score_torso;
        }

        public Double getScore_shoulder_left() {
            return score_shoulder_left;
        }

        public void setScore_shoulder_left(Double score_shoulder_left) {
            this.score_shoulder_left = score_shoulder_left;
        }

        public Double getScore_shoulder_right() {
            return score_shoulder_right;
        }

        public void setScore_shoulder_right(Double score_shoulder_right) {
            this.score_shoulder_right = score_shoulder_right;
        }

        public Double getScore_neck() {
            return score_neck;
        }

        public void setScore_neck(Double score_neck) {
            this.score_neck = score_neck;
        }
    }
}
