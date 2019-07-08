package concurrent2.future;

/**
 * @author: bxguo
 * @time: 2019/7/8 16:21
 */
public class Host {
  public Data get(String str){
      final FutureData futureData = new FutureData();
      new Thread(() -> {
          RealData realData = new RealData(str);
          futureData.setRealData(realData);
          System.out.println(str + "准备好了");
      }).start();
      return futureData;
  }
}
