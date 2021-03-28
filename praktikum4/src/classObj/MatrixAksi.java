package classObj;


public class MatrixAksi {
	public static void main(String[] args) {
		// double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
		//Matrix D = new Matrix(d);
		// D.show();
		// System.out.println();
		
		// matrix random 4x4
		System.out.println("Matrix A");
		Matrix A = Matrix.random(4, 4);
		A.show();
		System.out.println();
		
		System.out.println("Matrix B = Transpose A");
		// matrix transpose
		Matrix B = A.transpose();
		B.show();
		System.out.println();
		
		System.out.println("Matrix Identitas");
		// matrix identitas
		Matrix C = Matrix.identity(4);
		C.show();
		System.out.println();
		
		System.out.println("Matrix A+B");
		// penjumlahan matrix
		Matrix jumlah = A.plus(B);
		jumlah.show();
		System.out.println();
		
		System.out.println("Matrix AxB");
		// perkalian matrix
		Matrix kali = A.times(B);
		kali.show();
		System.out.println();
		
		
	}
}