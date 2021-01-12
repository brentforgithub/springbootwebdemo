package com.brent.demo.dao;

import com.brent.demo.mode.po.NameDemo;
import com.brent.demo.mode.po.NameDemoExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;


@SpringBootTest
class NameDemoMapperTest {

    @Autowired
    private NameDemoMapper nameDemoMapper;

    private static Random random = new Random();

    private static Set<String> phone = new HashSet<>(3000000);


    @Test
    void insertBatch() {
        long now = System.currentTimeMillis();
        //10年前
        now = now - 1000l*60*60*24*365*10;
        for(int z=30,x=z;z<31;z++){
            for(int y=0;y<150;y++){
                List<NameDemo> demos = new ArrayList<>(20000);
                for (int i=0;i<20000;i++){
                    NameDemo nameDemo = new NameDemo();
                    nameDemo.setAge(random.nextInt(100) + 20);
                    now = now + random.nextInt(60)*100;
                    nameDemo.setCreateTime(new Date(now));
                    nameDemo.setTelephone(getNewRandomTelephone("" + z,random));
                    nameDemo.setCName(getRandomName(random.nextInt(4) + 1));
                    nameDemo.setCState(random.nextInt(6) + 1);
                    demos.add(nameDemo);
                    //nameDemoMapper.insert(nameDemo);
                }
                long st = System.currentTimeMillis();
                nameDemoMapper.insertList(demos);
                System.out.println("新增时长" + (System.currentTimeMillis()-st));
                System.out.println("新增" + ((z-x)*3000000 + y*20000) + "条");
            }
            phone.clear();
        }


    }

    public static String  getNewRandomTelephone(String pr,Random random){
        long num = phone.size();
        String newPhone = "";
        do{
            newPhone = getRandomTelephone(pr,random);
            phone.add(newPhone);
        }while (num == phone.size());
        return newPhone;
    }

    public static String  getRandomTelephone(String pr,Random random){
        StringBuffer buffer = new StringBuffer(pr);
        for(int i = 0;i<11-pr.length();i++){
            buffer.append(random.nextInt(10));
        }
        return buffer.toString();
    }

    public static String  getRandomName(int y){
        StringBuffer buffer = new StringBuffer();
        for(int i = 0;i<y;i++){

            buffer.append(getRandomChar());
        }
        return buffer.toString();
    }
    public static char getRandomChar() {
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
    }

    @Test
    public void testTime(){
        long now = System.currentTimeMillis();
        System.out.println(now);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(now)));
        //10年前
        now = now - 1000l*60*60*24*365*10;
        System.out.println(1000l*60*60*24*365*10);
        now = now - 1000;
        System.out.println(now);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(now)));
    }

    public static void test01(){
        if(1 != 2){

        }
    }

    /**
     * 在4000万数据中修改10万数据的状态
     */
    @Test
    public void changeState(){

        List<Integer> ids = new ArrayList<>();
        for(int i = 1432022;i <= 39772021; i += 400){
            ids.add(i);
            if(ids.size() > 5000 || i > 39772021){
                long st = System.currentTimeMillis();
                NameDemoExample example = new NameDemoExample();
                example.createCriteria().andIdIn(ids);
                List<NameDemo> nameDemos = nameDemoMapper.selectByExample(example);
                System.out.println("查询时长" + (System.currentTimeMillis()-st));
                st = System.currentTimeMillis();
                if(!CollectionUtils.isEmpty(nameDemos)){
                    for(NameDemo nameDemo : nameDemos){
                        nameDemo.setCState(20);
                        nameDemoMapper.updateByPrimaryKey(nameDemo);
                    }
                }
                System.out.println("修改时长" + (System.currentTimeMillis()-st));
                ids.clear();
            }
        }

    }



}