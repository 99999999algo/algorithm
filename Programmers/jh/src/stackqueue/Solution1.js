function solution(progresses, speeds) {
  let answer = [];
  //progresses 는 배열사용 큐 speeds는 회차별 더해질 양
  let days = 0;

  while (progresses.length > 0) {
    progresses = progresses.map((v, idx) => {
      //각 더한다
      return v + speeds[idx];
    });
    if (progresses[0] >= 100) {
      let count = 0;
      while (progresses[0] >= 100) {
        progresses.shift();
        speeds.shift();
        count++;
      }
      answer.push(count);
    }
  }

  return answer;
}
