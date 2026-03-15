package acumuladores;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila 
	 * donde todos sus elementos sean múltiplos del número recibido por 
	 * parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	 */
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) { 
//		throw new RuntimeException("Metodo no implementado aun!!!");
		if (mat.length == 0 || num <= 0) return false;
		
		boolean ret = false;
		
		for (int fila = 0; fila < mat.length; fila++) {
			boolean esDivisible = true;
			
			for (int col = 0; col < mat[0].length; col++) {
				esDivisible &= (mat[fila][col] % num == 0);
			}
			ret |= esDivisible;
		}
		return ret;
	}
	
	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz 
	 * está vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) { 
//		throw new RuntimeException("Metodo no implementado aun!!!");
		if (mat1.length != mat2.length || mat1.length == 0 || mat2.length == 0) return false;
		
		boolean ret = true;
		
		for (int fila = 0; fila < mat1.length; fila++) {
			boolean interseccion = false;
			
			for (int col = 0; col < mat1[0].length; col++) {
				interseccion |= apareceEnFila(mat1[fila][col], mat2[fila]);
			}
			ret &= interseccion;
		}
		return ret;
	}
	
	public boolean apareceEnFila(int valor, int[] arreglo) {
		
		boolean esIgual = false;
		
		for (int elem = 0; elem < arreglo.length; elem++) {
			esIgual |= (valor == arreglo[elem]);
		}
		return esIgual;
	}
	
	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve 
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	 */
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) { 
//		throw new RuntimeException("Metodo no implementado aun!!!");
		if (mat.length == 0 || 
			nColum >= mat[0].length || 
			nColum < 0) return false;
		
		boolean ret = false;
		
		int sumaCol = sumaCol(mat , nColum);
		
		for (int fila = 0; fila < mat.length; fila++) {
			int sumaFila = 0;
			for (int col = 0; col < mat[0].length; col++) {
				sumaFila += mat[fila][col];
			}
			ret |= (sumaFila > sumaCol);
		}
		return ret;

	}
	
	public int sumaCol(int[][] mat, int nColum) {
		int suma = 0;
		
		for (int fila = 0; fila < mat.length; fila++) {
			suma += mat[fila][nColum];
		}
		return suma;
	}
	
	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de
	 * cada matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz 
	 * está vacía, devuelve falso. 
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) { 
//		throw new RuntimeException("Metodo no implementado aun!!!");
		if (mat1.length == 0 || 
			mat2.length == 0 || 
			mat1[0].length != mat2[0].length) return false;
		
		boolean ret = true;
		
		for (int col = 0; col < mat1[0].length; col++) {
			boolean interseccion = false;
			
			for (int fila = 0; fila < mat1.length; fila++) {
				interseccion |= apareceEnCol(mat1[fila][col], mat2, col);
			}
			ret &= interseccion;
		}
		return ret;
	}
	
	public boolean apareceEnCol(int valor, int[][] mat, int col) {
		boolean ret = false;
		
		for (int fila = 0; fila < mat.length; fila++) {
			ret |= (valor == mat[fila][col]);
		}
		return ret;
	}
}
