import java.util.*;
public class Main {

    public static boolean findPoint(HashSet<String> map, int x, int y,String isDir,int n) {
        if(Objects.equals(isDir, "left")){
            while(x>=0){
                if(map.contains(x+""+y)){
                    return true;
                }
                x--;
            }
        }
        if(Objects.equals(isDir, "right")){

            while(x<n){
                if(map.contains(x+""+y)){
                    return true;
                }
                x++;
            }
        }
        if(Objects.equals(isDir, "down")){

            while(y>=0){
                if(map.contains(x+""+y)){
                    return true;
                }
                y--;
            }
        }
        if(Objects.equals(isDir, "up")){

            while(y<n){
                if(map.contains(x+""+y)){
                    return true;
                }
                y++;
            }
        }

        return false;
    }



    public static void main(String[] args) {
        List<Integer> x = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 3, 3, 3);
        List<Integer> y = Arrays.asList(1, 2, 3, 1, 2, 3, 5, 1, 2, 3);

        HashSet<String> map = new HashSet<>();

        for (int i = 0; i < x.size(); i++) {
            map.add(x.get(i)+""+ y.get(i));
        }

        int idleCount = 0;
        for(int i = 0; i < x.size(); i++) {
                boolean left = findPoint(map,x.get(i)-1,y.get(i),"left",x.size());
                boolean right = findPoint(map,x.get(i)+1,y.get(i),"right",x.size());
                boolean down = findPoint(map,x.get(i),y.get(i)-1,"down",x.size());
                boolean up = findPoint(map,x.get(i),y.get(i)+1,"up",x.size());
                if(left && right && down && up){
                    idleCount++;
                }
        }
        System.out.println(idleCount);

    }
}
