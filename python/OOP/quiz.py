class quiz:

    def __init__(self, t, desc, ans):
        self.title = t
        self.desc = desc
        self.ans = ans

    def solve(self):
        print(self.title, end = '\n')
        print(self.desc, end = '\n')
        user = input("답을 입력하시오")

        return self.ans == user