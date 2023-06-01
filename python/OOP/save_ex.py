

class PiggySave:

    def __init__(self):
        self.money = 0

    def deposite(self, coin):
        self.money = self.money + coin

    def open(self):
        total = self.money
        self.money = 0
        return total

    def __str__(self):
        return "TOTAL: " + str(self.money)


save1 = PiggySave()

save2  = PiggySave()

targetSave = None

while True:
    oper = input("A or B")

    if oper  == 'A':
        targetSave = save1
    else:
        targetSave = save2

    user_input = int(input("얼마 넣을래?"))
    targetSave.deposite(user_input)
    print(targetSave)


