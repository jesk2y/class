s0 = {'desc': '뒤쳐지는 조원이 있다면 좀 늦더라도 이끌어줘야 한다고 생각한다', 'yes': None, 'no': None}
s1 = {'desc': '지시를 받기 보다 스스로 일을 만들어 하는 스타일이다', 'yes': None, 'no': None}
s2 = {'desc': '자고로 화장품은 올리브영 영화관은 CGV다', 'yes': None, 'no': None}
s3 = {'desc': 'SKY출신은 아니지만 전공분야 만큼은 누구보다 잘 알고 있다', 'yes': None, 'no': None}
s4 = {'desc': '좋은게 좋은것~ 성격이 낙천적인 편이다', 'yes': None, 'no': None}
s5 = {'desc': '조별모임을 하면 늘 먼저 아이디어를 제시한다', 'yes': None, 'no': None}
s6 = {"desc": "한국사와 한자에 관심이 많다.", "yes" : None, "no" : None}
s7 = {"desc": "개인목표보다는 팀 목표가 더 중요하다.", "yes" : None, "no" : None}
s8 = {"desc": "돈보다는 도전을 택하겠다.", "yes" : None, "no" : None}
s9 = {"desc": "과제는 밤을 새서라도 끝까지 한다.", "yes" : None, "no" : None}
s10 = {"desc": "부모님이나 교수님의 지시를 거스른 적이 거의 없다.", "yes" : None, "no" : None}
s11 = {"desc": "외국어를 잘하거나 잘하고 싶은 마음이 있다.", "yes" : None, "no" : None}

A = "삼성"
B = "LG"
C = "CJ"


s0["yes"] = s1
s0["no"] = s3
s1["yes"] = s2
s1["no"] = s4
s2["yes"] = s5
s2["no"] = s4
s3["yes"] = s6
s3["no"] = s4
s4["yes"] = s7
s4["no"] = s8
s5["yes"] = s8
s5["no"] = s4
s6["yes"] = s10
s6["no"] = s9
s7["yes"] = s10
s7["no"] = s6
s8["yes"] = s11
s8["no"] = s7
s9["yes"] = A
s9["no"] = B
s10["yes"] = B
s10["no"] = s9
s11["yes"] = C
s11["no"] = B



current = s0

while True:
    if (current == A) or (current == B) or (current == C):
        print(current,"당첨!")
        break
    print(current['desc'])
    user_input = input("yes or no")
    current = current[user_input]