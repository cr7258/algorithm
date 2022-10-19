fn main() {
    //let strs = vec![String::from("flower"),String::from("flow"),String::from("flight")];
    let strs = vec![String::from("ab"),String::from("a")];
    let result = longest_common_prefix(strs);
    println!("{}", result)
}



pub fn longest_common_prefix(strs: Vec<String>) -> String {
    let length = strs[0].len(); // 以第一个字符串的长度为基准比较
    let count = strs.len();
    // 遍历字符串的每一个字符
    for i in 0..length {
        // 遍历每个字符串，跳过第一个字符串
        for j in 1..count {
            if i == strs[j].len() || strs[0].chars().nth(i).unwrap() != strs[j].chars().nth(i).unwrap() {
                return strs.get(0).unwrap()[0..i].to_string();
            }
        }
    }
    return strs[0].to_string();
}