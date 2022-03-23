function solution(clothes) {
  let answer = 1;
  let clothesMap = new Map();

  clothes.forEach((value) => {
    const [, category] = value;

    if (clothesMap.has(category)) {
      clothesMap.set(category, clothesMap.get(category) + 1);
    } else clothesMap.set(category, 2);
  });

  clothesMap.forEach((v) => {
    answer *= v;
  });

  return answer - 1;
}
