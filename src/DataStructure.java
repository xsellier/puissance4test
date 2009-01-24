package src;

public class DataStructure {
	private int[][] matrix;
	private int height;
	private int width;

	public DataStructure(int height, int width) {
		if (height < 0)
			height = 6;
		if (width < 0)
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

	public int[][] getMatrix() {
		return matrix;
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

	public void setValue(int i, int j, int color) {
		matrix[i][j] = color;

	}

	public int getValue(int i, int j) {
		return matrix[i][j];
	}

}
