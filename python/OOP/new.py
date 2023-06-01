import random
class Dragon:

    def __init__(self, lev):
        self.lev = lev
        self.hp = lev * 10
        self.jewel = lev % 3

    def giveJewel(self):
        return self.jewel

    def attackHero(self):
        print("캬오~~~~~~~~~~")
        return random.randint(1, (self.lev * 10))

    def damage(self, amount):
        print("윽............")
        self.hp -= amount
        if self.hp > 0:
            print("체력이" , self.hp , "로 줄었다")
        else:
            print("분하다.........복수할테다..")
        return self.hp

    def __str__(self):
        return "용 레벨" + str(self.lev)+":" + str(self.hp)

class Hero:

    def __init__(self, name, hp):
        self.name = name
        self.hp = hp
        self.mp = 100 - hp

    def attackDragon(self):
        return  random.randint(1, self.mp)

    def damage(self, amount):
        print("윽............")
        self.hp -= amount
        if self.hp > 0:
            print("플레이어의 체력이" , self.hp , "로 줄었다")
        else:
            print("용사는 드래곤의 밥이 되었다.")
        return self.hp

    def __str__(self):
        return self.name + "님 " + str(self.hp)


class DragonContainer:

    def __init__(self):
        self.dragons = [ Dragon(x) for x in range(1,11) ]

    def getNext(self):
        if len(self.dragons) == 0:
            return None
        return self.dragons.pop(0)

class Colosseum:

    def __init__(self):
        self.container = DragonContainer()
        self.player = None


    def makePlayer(self):
        name = input('플레이어의 이름은?')
        hp = int(input("HP는 얼마나? 100못 넘어요"))
        self.player = Hero(name, hp)
        print(self.player, "가 만들어 졌습니다.")

    def fight(self):
        print("BGM..... start....")
        dragon = self.container.getNext()

        if dragon == None:
            print("용사는 전설이 되었다.")
            return

        print(dragon)

        while True:
            power = self.player.attackDragon()
            print("용사가 공격했다.", power)
            dragonhp = dragon.damage(power)
            if dragonhp <= 0:
                jewel = dragon.giveJewel()

                if jewel == 0:
                    self.player.hp += 10

                break

        self.fight()

ground = Colosseum()
ground.makePlayer()
ground.fight()