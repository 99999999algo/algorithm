function solution(participant, completion) {
  let answer;
  participant = participant.sort();
  completion = completion.sort();

  for (let i = 0; i < participant.length; i++) {
    if (participant[i] !== completion[i]) {
      return (answer = participant[i]);
    }
  }

  return answer.toString();
}
