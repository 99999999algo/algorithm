function solution(priorities, location) {
  let answer = 0;
  let priByIdx = new Map();
  let priMap = new Map();
  let printCount = 0;
  let doci = 0;
  let documents = Array.from({ length: priorities.length }, () => doci++);
  priorities.forEach((v, idx) => {
    priByIdx.set(idx, v);

    if (priMap.has(v)) {
      let temp = priMap.get(v);
      temp.push(idx);
      priMap.set(v, temp);
    } else priMap.set(v, [idx]);
  });
  // priByIdx.forEach(v => console.log(v));
  // priMap.forEach(v => console.log(v));

  // let cc=0;
  while (documents.length > 0) {
    let idx = documents[0];
    let priority = priByIdx.get(idx);
    let check = false;
    for (let i = priority + 1; i < 10; i++) {
      if (priMap.has(i)) {
        check = true;
        break;
      }
    }

    if (check === true) {
      documents.push(documents.shift());
    } else {
      printCount++;
      let print = documents.shift();
      if (print === location) return printCount;
      if (priMap.get(priority).length === 1) priMap.delete(priority);
      else {
        let temp = priMap.get(priority);
        temp.splice(temp.indexOf(idx), 1);
        priMap.set(priority, temp);
      }
    }
  }
}
