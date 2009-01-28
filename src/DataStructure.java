package src;

public class DataStructure {
	private int[][] matrix;
	private int height;
	private int width;

	// create a matrix
	public DataStructure(int height, int width) {
		if (height < 6)
			height = 6;
		if (width < 7)
			width = 7;
		this.height = height;
		this.width = width;
		this.matrix = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = 0;
			}
		}

	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void print() {
		for (int i = 0; i < height; i++) {
			System.out.print("Ligne : " + i + " | ");
			for (int j = 0; j < width; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void reset_matrix(){
		for(int i=0;i<width;++i)
			for(int j=0;j<height;++j)
				setValue(j, i, 0);
	}
	
	public boolean setValue(int i, int j, int color) {
		if(i>=height || j>=width || i<0 || j<0)
			return false;
		else{
		matrix[i][j] = color;
		return true;
		}
	}

	public int getValue(int i, int j) {
		return matrix[i][j];
	}

}

