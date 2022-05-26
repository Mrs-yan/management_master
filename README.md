# management_master
便民管理系统
时间差统计
 long hour = 1000*60*60;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startTime = "2022-05-16 01:50:00";
        String endTime = "2022-05-18 00:00:00";
        long timeVariance = format.parse(endTime).getTime() - format.parse(startTime).getTime();
        System.out.println(timeVariance/hour);

计算累计收入
SELECT SUM(f.money) FROM financial f
JOIN task t on f.task_id = t.id
where t.equipment_id = 1 and f.type = '收入' and t.`status`  = 1


 public void uploadPicture(MultipartFile file) throws IOException {
        // 允许上次的文件类型
        String[] picture = {"jpg", "JPG", "PNG", "png", "JPEG", "jpeg"};
        
        // 获取文件名称
        String filename = file.getOriginalFilename();
        
        // 生成不唯一名称
        String newFilename = "" + System.currentTimeMillis() + UUID.randomUUID().toString().trim().replaceAll("-", "");
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
        if (Arrays.asList(picture).contains(suffix)) {
            // path 为路径比如   E:/ManagementImg/   写你自己的项目static静态文件地址
            String filepath = path + newFilename + "." + suffix;
            String resultName = newFilename + "." + suffix;
            File f = new File(filepath);
            Files.copy(file.getInputStream(), f.toPath());
            // 次为能访问图片的url地址
        } else {
            System.out.println("文件类型错误！");
        }
    }
