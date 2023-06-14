// TODO 数组最好使用在索引有语义的地方

let arr: number[] = [1,2,3]
for (let i = 0; i < arr.length; i++) {
    console.log(arr[i])
}

let arr2: string[] = new Array('zack','zheng','zhang','li')

for (const item of arr2) {
    console.log(item);
}
 

let arr3: Array<string | number> = [20,'zack']
for (const item of arr3) {
    console.log(item);
}
