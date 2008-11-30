public class DataStructure {
	private int[][] matrix;

	DataStructure(int heigth, int width) {
		this.matrix = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	
	int[][] getMatrix(){
		return matrix;
	}
	
	boolean setMatrix(int i, int j, int color){
		if(matrix[i][j]==0){
			matrix[i][j]=color;
			return true;
		}
		return false;
	}
}
