package hhu.jswang.enpicture;
/*
	一系列数组方面的操作
 */
public class ArrayFunctions {
	 int random(int m, int n) 
	{
		return m + (int) (Math.random() * n);
	}
	//二维数组降一维
	void recovery(int arr2[][], int arr1[], int M, int N)
	{
		int k = 0;
		for (int i = 0; i < M; ++i)
		for (int j = 0; j < N; ++j)
		{
			arr1[k++] = arr2[i][j];
		}

	}
	//一维数组升二维
	void change(int arr1[], int arr2[][], int M, int N)
	{
		int k = 0;
		for (int i = 0; i < M; ++i)
		for (int j = 0; j < N; ++j)
		{
			arr2[i][j] = arr1[k++];
		}

	}
	//生成一个随机的象素模拟数组
	void produce_pixel_array(int pixel[], int M, int N)
	{
		for (int i1 = 0; i1 < M*N; ++i1)
		{
			pixel[i1] = random(1, 10);

		}
	}
	//用于交换数组中的两个元素


	//把二维数组行列倒换
	void arr_change(int arr[][],int temp[][], int M, int N)
	{
		for (int i = 0; i < M; ++i)
		{
			for (int j = 0; j < N; ++j)
				temp[j][i] = arr[i][j];
		}
		/*
		for (int i = 0; i < M; ++i)
		{
			for (int j = 0; j < N; ++j)
				arr[i][j] = temp[i][j];
		}*/
	}

	//把arr1复制给arr2
	void arr_copy(double arr1[], double arr2[], int N)
	{
		for (int i = 0; i < N; ++i)
		{
			arr2[i] = arr1[i];
		}
	}

}
