// 顶点类
class Vertex {
    val: number;
    constructor(val: number) {
      this.val = val;
    }

    // 输入值列表vals，返回顶点列表vets
    // 数字数组的顶点列表转换为Vertex类型的数组
    public static valsToVets(vals: number[]): Vertex[] {
      const vets: Vertex[] = [];
      for(let i=0;i<vals.length;i++) {
        vets[i] = new Vertex(vals[i]);
      }
      return vets;
    }

    // 输入顶点列表vets，返回值列表vals
    // 把所有顶点以数字数组的形式输出
    public static vetsToVals(vets: Vertex[]): number[] {
      const vals: number[] = [];
      for(const vet of vets) {
        vals.push(vet.val);
      }
      return vals;
    }
}

export { Vertex };
