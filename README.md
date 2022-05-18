# management_master
便民管理系统
时间差统计
 long hour = 1000*60*60;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startTime = "2022-05-16 01:50:00";
        String endTime = "2022-05-18 00:00:00";
        long timeVariance = format.parse(endTime).getTime() - format.parse(startTime).getTime();
        System.out.println(timeVariance/hour);
