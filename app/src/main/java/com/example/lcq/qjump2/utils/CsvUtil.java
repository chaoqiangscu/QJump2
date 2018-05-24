package com.example.lcq.qjump2.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvUtil {
    private static final String TAG = "CSV Util";
    //懒汉式单例模式的创建
    private static CsvUtil instance = null;
    public static CsvUtil instance() {
        if(null == instance) {
            instance = new CsvUtil();
        }
        return instance;
    }

    private File mResultFile = null;
    private File mResultsFolder = null;

    private CsvUtil() {
    }

    //创建位于根目录的文件夹及文件
    public void createFile(Context ctx, String participantId, String age, String sex) {
        mResultsFolder = new File(Environment.getExternalStorageDirectory(), "AAC-QJump2" + File.separator + "Q弹测试数据");    //创建“AAC-Results文件夹
        if(!mResultsFolder.exists()) {
            mResultsFolder.setReadable(true);   //文件夹设置可读
            if (!mResultsFolder.mkdirs()) {
                Toast.makeText(ctx, "Error creating AAC result directory", Toast.LENGTH_LONG).show();
                return;
            }
        }
        SimpleDateFormat s = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String resultsFileName = participantId + "号测试者" + s.format(new Date()) + ".csv";    //待保存文件的名称，文件类型可自定义
        mResultFile = new File(mResultsFolder.getPath(), resultsFileName);  //创建测试结果的保存文件
        try {
            mResultFile.createNewFile();    //真正创建文件
            appendTestHeader(participantId,age,sex);
        } catch(Exception e) {
            mResultFile = null;
            Toast.makeText(ctx, "Error creating AAC result file! Your results will not be saved!", Toast.LENGTH_LONG).show();
        }
    }

    //添加表头
    public void appendTestHeader(String participantId, String age, String sex) {
        if(null != mResultFile) {
            try {
                FileOutputStream fOut = new FileOutputStream(mResultFile, true);
                OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
                outWriter.append(getCsvHeader(participantId,age,sex));      //设置CSV文件的第一行（即表头）
                outWriter.close();
                fOut.close();
            } catch(Exception e) {
                Log.e(TAG, "Error writing test item to csv file!", e);
            }
        }
    }

    //设置CSV文件的第一行（即表头）
    public String getCsvHeader(String participantId, String age, String sex) {
        StringBuilder sb = new StringBuilder();
        sb.append("编号：").append(participantId).append("\t").append("\t").append("\t")
                .append("年龄：").append(age).append("\t").append("\t").append("\t")
                .append("性别：").append(sex).append("\t").append("\t").append("\t")
                .append("\n");
        return sb.toString();
    }

    //添加测试者觉得哪个信号更“Q弹”
    public void appendSelection(String selection){
        if(null != mResultFile) {
            StringBuilder sb = new StringBuilder();
            try {
                FileOutputStream fOut = new FileOutputStream(mResultFile, true);
                OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
                sb.append("意见：").append(selection).append("\n");
                outWriter.append(sb.toString());
                outWriter.close();
                fOut.close();
            } catch(Exception e) {
                if(TextUtils.isEmpty(sb.toString())) {
                    Log.e(TAG, "Error writing test item to csv file!", e);
                } else {
                    Log.e(TAG, "CSV Write Error: " + sb.toString());
                }
            }
        }
    }

    //添加联合任务一的测试结果
    public void appendUnionFirstResults(int[] results){
        if(null != mResultFile) {
            StringBuilder sb = new StringBuilder();
            try {
                FileOutputStream fOut = new FileOutputStream(mResultFile, true);
                OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
                sb.append("联合测试一:").append("\n")
                        .append("\t").append("\t").append("\t").append("信号1：").append("\t").append(results[0]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号2：").append("\t").append(results[1]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号A：").append("\t").append(results[2]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号B：").append("\t").append(results[3]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号C：").append("\t").append(results[4]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号D：").append("\t").append(results[5]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号E：").append("\t").append(results[6]).append("\t").append("\n")
                        .append("\t").append("\t") .append("\t").append("信号F：").append("\t").append(results[7]).append("\t").append("\n");
                outWriter.append(sb.toString());
                outWriter.close();
                fOut.close();
            } catch(Exception e) {
                if(TextUtils.isEmpty(sb.toString())) {
                    Log.e(TAG, "Error writing test item to csv file!", e);
                } else {
                    Log.e(TAG, "CSV Write Error: " + sb.toString());
                }
            }
        }
    }

    //添加联合任务二的测试结果
    public void appendUnionSecondResults(int[] results){
        if(null != mResultFile) {
            StringBuilder sb = new StringBuilder();
            try {
                FileOutputStream fOut = new FileOutputStream(mResultFile, true);
                OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
                sb.append("联合测试二:").append("\n")
                        .append("\t").append("\t").append("\t").append("信号1：").append("\t").append(results[0]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号2：").append("\t").append(results[1]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号G：").append("\t").append(results[2]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号H：").append("\t").append(results[3]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号I：").append("\t").append(results[4]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号J：").append("\t").append(results[5]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号K：").append("\t").append(results[6]).append("\t").append("\n")
                        .append("\t").append("\t").append("\t").append("信号L：").append("\t").append(results[7]).append("\t").append("\n");
                outWriter.append(sb.toString());
                outWriter.close();
                fOut.close();
            } catch(Exception e) {
                if(TextUtils.isEmpty(sb.toString())) {
                    Log.e(TAG, "Error writing test item to csv file!", e);
                } else {
                    Log.e(TAG, "CSV Write Error: " + sb.toString());
                }
            }
        }
    }

    //将UnionTask的测试结果写入文档
    public void appendUnionResult(String scene, String[] answerAdjective, float[] responseTimeAdjective,
                                  String[] userAnswerAdjective, String[] isTrueAdjective, float accuracyAdjective) {
        if(null != mResultFile) {
            String csvRow = "";
            StringBuilder sb = new StringBuilder();
            try {
                FileOutputStream fOut = new FileOutputStream(mResultFile, true);
                OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
                for (int i=0;i<70;i++){         //测试次数为70，故此处记录70次数据
                    sb.append(scene).append("；   ")
                            .append(answerAdjective[i]).append("；   ")
                            .append(responseTimeAdjective[i]).append("；   ")
                            .append(userAnswerAdjective[i]).append("；   ")
                            .append(isTrueAdjective[i]).append("；   ")
                            .append("\n");
                }
                csvRow = sb.append(scene + "测试正确率: ").append(accuracyAdjective).append("\n").toString();
                outWriter.append(csvRow);

                outWriter.close();
                fOut.close();
            } catch(Exception e) {
                if(TextUtils.isEmpty(csvRow)) {
                    Log.e(TAG, "Error writing test item to csv file!", e);
                } else {
                    Log.e(TAG, "CSV Write Error: " + csvRow);
                }
            }
        }
    }

    //将SecondPartionTask的测试结果写入文档
    public void appendSecondPartionTaskResult(String scene, int[] answerAdjective, float[] responseTimeAdjective,
                                              int[] userAnswerAdjective, String[] isTrueAdjective, float accuracyAdjective) {
        if(null != mResultFile) {
            String csvRow = "";
            StringBuilder sb = new StringBuilder();
            try {
                FileOutputStream fOut = new FileOutputStream(mResultFile, true);
                OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
                for (int i=0;i<40;i++){         //FirstPartionTask的测试次数为40，故此处记录40次数据
                    sb.append(scene).append("；   ")
                            .append(answerAdjective[i]).append("；   ")
                            .append(responseTimeAdjective[i]).append("；   ")
                            .append(userAnswerAdjective[i]).append("；   ")
                            .append(isTrueAdjective[i]).append("；   ")
                            .append("\n");
                }
                csvRow = sb.append("SecondPartionTask测试正确率: ").append(accuracyAdjective).append("\n").toString();
                outWriter.append(csvRow);

                outWriter.close();
                fOut.close();
            } catch(Exception e) {
                if(TextUtils.isEmpty(csvRow)) {
                    Log.e(TAG, "Error writing test item to csv file!", e);
                } else {
                    Log.e(TAG, "CSV Write Error: " + csvRow);
                }
            }
        }
    }

    //将FirstPartionTask的测试结果写入文档
    public void appendFirstPartionTaskResult(String scene, int[] answerAdjective, float[] responseTimeAdjective,
                                             int[] userAnswerAdjective, String[] isTrueAdjective, float accuracyAdjective) {
        if(null != mResultFile) {
            String csvRow = "";
            StringBuilder sb = new StringBuilder();
            try {
                FileOutputStream fOut = new FileOutputStream(mResultFile, true);
                OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
                for (int i=0;i<40;i++){         //FirstPartionTask的测试次数为40，故此处记录40次数据
                    sb.append(scene).append("；   ")
                            .append(answerAdjective[i]).append("；   ")
                            .append(responseTimeAdjective[i]).append("；   ")
                            .append(userAnswerAdjective[i]).append("；   ")
                            .append(isTrueAdjective[i]).append("；   ")
                            .append("\n");
                }
                csvRow = sb.append("FirstPartionTask测试正确率: ").append(accuracyAdjective).append("\n").toString();
                outWriter.append(csvRow);

                outWriter.close();
                fOut.close();
            } catch(Exception e) {
                if(TextUtils.isEmpty(csvRow)) {
                    Log.e(TAG, "Error writing test item to csv file!", e);
                } else {
                    Log.e(TAG, "CSV Write Error: " + csvRow);
                }
            }
        }
    }

   //将AdjectiveTest的测试结果写入文档
   public void appendAdjectiveTestResult(String scene, String[] answerAdjective, float[] responseTimeAdjective,
                                         String[] userAnswerAdjective, String[] isTrueAdjective, float accuracyAdjective) {
       if(null != mResultFile) {
           String csvRow = "";
           StringBuilder sb = new StringBuilder();
           try {
               FileOutputStream fOut = new FileOutputStream(mResultFile, true);
               OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
               for (int i=0;i<20;i++){         //RandomHaptics的测试次数为20，故此处记录20次数据
                   sb.append(scene).append("；   ")
                           .append(answerAdjective[i]).append("；   ")
                           .append(responseTimeAdjective[i]).append("；   ")
                           .append(userAnswerAdjective[i]).append("；   ")
                           .append(isTrueAdjective[i]).append("；   ")
                           .append("\n");
               }
               csvRow = sb.append("AdjectiveTest测试正确率: ").append(accuracyAdjective).append("\n").toString();
               outWriter.append(csvRow);

               outWriter.close();
               fOut.close();
           } catch(Exception e) {
               if(TextUtils.isEmpty(csvRow)) {
                   Log.e(TAG, "Error writing test item to csv file!", e);
               } else {
                   Log.e(TAG, "CSV Write Error: " + csvRow);
               }
           }
       }
   }

    //将RandomHaptics的测试结果写入文档
    public void appendRandomTestResult(String scene, int[] answerRandom, float[] responseTimeRandom,
                                       int[] userAnswerRandom, String[] isTrueRandom, float accuracyRandom) {
        if(null != mResultFile) {
            String csvRow = "";
            StringBuilder sb = new StringBuilder();
            try {
                FileOutputStream fOut = new FileOutputStream(mResultFile, true);
                OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
                for (int i=0;i<20;i++){         //RandomHaptics的测试次数为20，故此处记录20次数据
                    sb.append(scene).append("；   ")
                            .append(answerRandom[i]).append("；   ")
                            .append(responseTimeRandom[i]).append("；   ")
                            .append(userAnswerRandom[i]).append("；   ")
                            .append(isTrueRandom[i]).append("；   ")
                            .append("\n");
                }
                csvRow = sb.append("RandomHaptics测试正确率: ").append(accuracyRandom).append("\n").toString();
                outWriter.append(csvRow);

                outWriter.close();
                fOut.close();
            } catch(Exception e) {
                if(TextUtils.isEmpty(csvRow)) {
                    Log.e(TAG, "Error writing test item to csv file!", e);
                } else {
                    Log.e(TAG, "CSV Write Error: " + csvRow);
                }
            }
        }
    }
    //将FirstSelect的测试结果写入文档
    public void appendFirstSelectTestResult(String scene, int[] answerFirstSelect, float[] responseTimeFirstSelect, int[] userAnswerFirstSelect, int[] isTrueFirstSelect, float accuracyFirstSelect){
        if(null != mResultFile) {
            String csvRow = "";
            StringBuilder sb = new StringBuilder();
            try {
                FileOutputStream fOut = new FileOutputStream(mResultFile, true);
                OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
                for (int i=0;i<40;i++){         //FirstSelect的测试次数为40，故此处记录40次数据
                    sb.append(scene).append("；   ")
                            .append(answerFirstSelect[i]).append("；   ")
                            .append(responseTimeFirstSelect[i]).append("；   ")
                            .append(userAnswerFirstSelect[i]).append("；   ")
                            .append(isTrueFirstSelect[i]).append("；   ")
                            .append("\n");
                }
                csvRow = sb.append("FirstSelect测试正确率: ").append(accuracyFirstSelect).append("\n").toString();
                outWriter.append(csvRow);

                outWriter.close();
                fOut.close();

            } catch(Exception e) {
                if(TextUtils.isEmpty(csvRow)) {
                    Log.e(TAG, "Error writing test item to csv file!", e);
                } else {
                    Log.e(TAG, "CSV Write Error: " + csvRow);
                }
            }
        }
    }

    //将SeconSelect的测试结果写入文档
    public void appendSecondSelectTestResult(String scene, int[] answerFirstSelect, float[] responseTimeFirstSelect, int[] userAnswerFirstSelect, int[] isTrueFirstSelect, float accuracyFirstSelect){
        if(null != mResultFile) {
            String csvRow = "";
            StringBuilder sb = new StringBuilder();
            try {
                FileOutputStream fOut = new FileOutputStream(mResultFile, true);
                OutputStreamWriter outWriter = new OutputStreamWriter(fOut);
                for (int i=0;i<40;i++){         //FirstSelect的测试次数为40，故此处记录40次数据
                    sb.append(scene).append("；   ")
                            .append(answerFirstSelect[i]).append("；   ")
                            .append(responseTimeFirstSelect[i]).append("；   ")
                            .append(userAnswerFirstSelect[i]).append("；   ")
                            .append(isTrueFirstSelect[i]).append("；   ")
                            .append("\n");
                }
                csvRow = sb.append("SecondSelect测试正确率: ").append(accuracyFirstSelect).append("\n").toString();
                outWriter.append(csvRow);

                outWriter.close();
                fOut.close();

            } catch(Exception e) {
                if(TextUtils.isEmpty(csvRow)) {
                    Log.e(TAG, "Error writing test item to csv file!", e);
                } else {
                    Log.e(TAG, "CSV Write Error: " + csvRow);
                }
            }
        }
    }

}
