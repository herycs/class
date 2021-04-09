package com.w.test;

/**
 * @ClassName modelBoolean
 * @Description [Boolean和integer的getter, setter]
 * @Author ANGLE0
 * @Date 2020/4/19 17:04
 * @Version V1.0
 **/
public class modelBoolean {

    class Model1{
        private Boolean success;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }
    }

    class Model2{
        private Boolean isSuccess;

        public Boolean getSuccess() {
            return isSuccess;
        }

        public void setSuccess(Boolean success) {
            isSuccess = success;
        }
    }

    class Model3{
        private boolean success;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }

    class Model4{
        private boolean isSuccess;

        public boolean isSuccess() {
            return isSuccess;
        }

        public void setSuccess(boolean success) {
            isSuccess = success;
        }
    }
}
