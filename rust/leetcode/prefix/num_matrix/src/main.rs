struct NumMatrix {
    pre_sum: Vec<Vec<i32>>
}


impl NumMatrix {

    fn new(matrix: Vec<Vec<i32>>) -> Self {
        let (n, m) = (matrix.len() + 1, matrix[0].len() + 1);
        let mut pre_sum = vec![vec![0; m];  n];
        for i in 1..n {
            for j in 1..m {
                pre_sum[i][j] = pre_sum[i-1][j] + pre_sum[i][j-1] + matrix[i-1][j-1] - pre_sum[i-1][j-1];
            }
        }
        Self {pre_sum: pre_sum}
    }

    fn sum_region(&self, row1: i32, col1: i32, row2: i32, col2: i32) -> i32 {
        let (x1, y1, x2, y2) = (row1 as usize, col1 as usize, row2 as usize, col2 as usize);
        self.pre_sum[x2 + 1][y2 + 1] + self.pre_sum[x1][y1] - self.pre_sum[x1][y2 + 1] - self.pre_sum[x2 + 1][y1]
    }
}

fn main() {
    let matrix = vec![
    vec![3,0,1,4,2],
    vec![5,6,3,2,1],
    vec![1,2,0,1,5],
    vec![4,1,0,1,7],
    vec![1,0,3,0,5],
    ];
    let obj = NumMatrix::new(matrix);
    let result = obj.sum_region(2, 1, 4, 3);
    println!("{}", result);
}