import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
	
	private static Node[][] map = new Node[70][70];
	
	public static void main(String args[]) throws IOException {
		generateNodes(70);
		generateMapFile(70);
	}
	
	public static void generateNodes(int size) {
		//i is row index
		for (int i=0;i<size;i++) {
			//j is column index
			for (int j=0;j<size;j++) {
				map[i][j] = new Node (i+""+j,(size-1-i)+(size-1-j),"F","F");
				Random rand = new Random();
				int n = rand.nextInt(100);
				n++;
				if (n <=10) {
					map[i][j].makeObstacle();
				}
			}
		}
		map[0][0] = new Node("S",(size*2)-2,"T","F");
		map[size-1][size-1] = new Node("F",0,"F","T");
	}
	
	public static void generateMapFile(int size) throws IOException {
		String fileString = "GeneratedMap1.txt";
		File f = new File(fileString);
		int n=2;
		while(f.exists()) {
			fileString = "GeneratedMap"+n+".txt";
			f = new File(fileString);
			n++;
		}
		
		FileWriter writer = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(writer);
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++) {
				Node node = map[i][j];
				bw.write(node.getName()+" "+node.getEstToFinish()+" "+node.isFirst()+" "+node.isGoal()+"\n");
			}
		}
		bw.write("\n");
		
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++) {
				if (map[i][j].isObstacle()) {
					continue;
				}
				Node node = map[i][j];
				if (j+1 != size) {
					if (!map[i][j+1].isObstacle()) {
						bw.write(node.getName()+" "+map[i][j+1].getName()+" 1\n");
					}
				}
				if (i+1 != size) {
					if (!map[i+1][j].isObstacle()) {
						bw.write(node.getName()+" "+map[i+1][j].getName()+" 1\n");
					}
				}
			}
		}
		bw.close();
	}
}
