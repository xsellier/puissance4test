package src;

public class DataStructure {
	private int[][] matrix;
	int height;
	int width;
	
	public
	DataStructure(int height, int width) {
		this.height=height;
		this.width=width;
		this.matrix = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	
	public int[][] getMatrix(){
		return matrix;
	}
	
	public void print(){
		for(int i=0;i<height; i++){
			System.out.print("Ligne : " + i + " | ");
			for(int j=0;j<width; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean setMatrix(int i, int j, int color){
		if(matrix[i][j]==0){
			matrix[i][j]=color;
			return true;
		}
		return false;
	}
}
