package _07kruskal;

// 一个对象表示一条边
public class EdgeData {
    char onePoint; // 边一端
    char anotherPoint; // 边另一端
    int weight;


    public EdgeData(char onePoint, char anotherPoint, int weight) {
        this.onePoint = onePoint;
        this.anotherPoint = anotherPoint;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "['" +  onePoint + "' " + "'"  +  anotherPoint + "' " +  weight + "]";
    }


    public int getWeight() {
        return weight;
    }

    
    
}
