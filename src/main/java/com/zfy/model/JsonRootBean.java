package com.zfy.model;

import java.util.List;

/**
 * Auto-generated: 2020-01-08 12:5:55
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

        private int score_overall;
        private int score_arom;
        private String visit_time;
        private int score_stability;
        private int score_symmetry;
        private List<Overactive_muscles> overactive_muscles;
        private List<Underactive_muscles> underactive_muscles;

        private Body_scores_arom body_scores_arom;
        private Body_scores_stability body_scores_stability;
        private Body_scores_symmetry body_scores_symmetry;

        public void setScore_overall(int score_overall) {
            this.score_overall = score_overall;
        }
        public int getScore_overall() {
            return score_overall;
        }

        public void setScore_arom(int score_arom) {
            this.score_arom = score_arom;
        }
        public int getScore_arom() {
            return score_arom;
        }

        public void setVisit_time(String visit_time) {
            this.visit_time = visit_time;
        }
        public String getVisit_time() {
            return visit_time;
        }

        public void setOveractive_muscles(List<Overactive_muscles> overactive_muscles) {
            this.overactive_muscles = overactive_muscles;
        }
        public List<Overactive_muscles> getOveractive_muscles() {
            return overactive_muscles;
        }

        public void setUnderactive_muscles(List<Underactive_muscles> underactive_muscles) {
            this.underactive_muscles = underactive_muscles;
        }
        public List<Underactive_muscles> getUnderactive_muscles() {
            return underactive_muscles;
        }

        public void setBody_scores_arom(Body_scores_arom body_scores_arom) {
            this.body_scores_arom = body_scores_arom;
        }
        public Body_scores_arom getBody_scores_arom() {
            return body_scores_arom;
        }

        public void setScore_stability(int score_stability) {
            this.score_stability = score_stability;
        }
        public int getScore_stability() {
            return score_stability;
        }

        public void setScore_symmetry(int score_symmetry) {
            this.score_symmetry = score_symmetry;
        }
        public int getScore_symmetry() {
            return score_symmetry;
        }

        public void setBody_scores_stability(Body_scores_stability body_scores_stability) {
            this.body_scores_stability = body_scores_stability;
        }
        public Body_scores_stability getBody_scores_stability() {
            return body_scores_stability;
        }

        public void setBody_scores_symmetry(Body_scores_symmetry body_scores_symmetry) {
            this.body_scores_symmetry = body_scores_symmetry;
        }
        public Body_scores_symmetry getBody_scores_symmetry() {
            return body_scores_symmetry;
        }

    }
