quiz_list = [
    {'title':'1', 'desc':'11','answer': 2},
    {'title':'2', 'desc':'22','answer': 2},
    {'title':'3', 'desc':'33','answer': 2},
    {'title':'4', 'desc':'44','answer': 2},
    {'title':'5', 'desc':'55','answer': 2},
]
score = 0
for quiz in quiz_list:
    print(quiz['title'])
    answer = int(input('정답번호를 입력하세요: '))
    if answer == quiz['answer']:
        print('정답입니다')
        score += 1
    else:
        print('탈락')
        break
    if (score == 5):
        print('합격!')
