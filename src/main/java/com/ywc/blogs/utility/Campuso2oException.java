package com.ywc.blogs.utility;

/**处理过程发生异常
 * @author 嘟嘟~~
 * @date 2019/12/30 20:26
 */
public class Campuso2oException extends RuntimeException {
    public Campuso2oException(String origin){
        super("{"+origin+"}发生了异常：");
    }
    public Campuso2oException(String origin,Exception ex){
        super("{"+origin+"}发生了异常："+parseErrMsg(ex));

    }

    private static String parseErrMsg(Exception ex) {
        if(ex == null){
            return "异常堆栈获为空";
        }
        String errMsg = "";
        StackTraceElement[] stackTrace = ex.getStackTrace();
        for (StackTraceElement s : stackTrace) {
            errMsg+="\tat " + s + "\r\n";
        }
        return errMsg;
    }
}
