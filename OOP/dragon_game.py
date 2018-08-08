import random
import time
class Dragon:

    def __init__(self, lev):
        self.lev = lev
        self.hp = lev * 10
        self.jewel = lev % 3

    def giveJewel(self):
        return self.jewel

    def attackHero(self):
        print("용: '캬오~~~~~~~!!!'")
        return random.randint(1, (self.lev * 10))

    def damage(self, amount):
        print("용: '윽............'")

        self.hp -= amount
        if self.hp > 0:
            print("[용의 체력이" , self.hp , "가 되었다]\n")
            time.sleep(1)
        else:
            print("[용의 체력이 0 이 되었다]")
            time.sleep(1)
            print("용: '분하다.........복수할테다..'")

        return self.hp

    def __str__(self):
        return "<레벨 %d 용> [체력: %d], [공격 데미지: 1 ~ %d]" % (self.lev, self.hp, self.lev*10)


class Hero:

    def __init__(self, name, hp):
        self.name = name
        self.hp = hp
        self.mp = 100 - hp
        self.min = 1
        self.list = [x for x in range(1, 11)]
    def attackDragon(self):
        return random.randint(1, self.mp)

    def damage(self, amount):
        print("%s: '으억!!!'" % str(self.name))
        time.sleep(1)
        self.hp -= amount
        if self.hp > 0:
            print("체력: %d -> %d" % (self.hp+amount, self.hp))
        else:
            print("[%s 는 드래곤의 밥이 되었다....]" % str(self.name))
        return self.hp

    def __str__(self):
        result = "[%s 님] [체력: %d], [공격 데미지: %d ~ %d]" % (str(self.name), self.hp, self.min, self.mp)
        return result

    def item_list(self):
        random.shuffle(self.list)
        return self.list.pop()

class DragonContainer:

    def __init__(self):
        self.dragons = [Dragon(x) for x in range(1, 11) ]

    def getNext(self):
        if len(self.dragons) == 0:
            return None
        return self.dragons.pop(0)

class Colosseum:

    def __init__(self):
        self.dragon = DragonContainer()
        self.player = None


    def makePlayer(self):
        name = input('플레이어의 이름은?')
        hp = int(input("HP는 얼마나? 100못 넘어요"))
        self.player = Hero(name, hp)
        print(self.player, "가 만들어 졌습니다.")

    def fight(self):
        input("")
        print("+++결투 시작++")
        time.sleep(1)
        dragon = self.dragon.getNext()
        hero = self.player
        if dragon == None:
            print("%s 는 전설이 되었다." % str(hero.name))
            return

        print("=============현재 상태===========")
        print(dragon)
        print(hero)
        print("=================================")
        input(" ")

        while True:
            power = self.player.attackDragon()
            print("[%s 가 %d 의 데미지로 공격했다]" % (str(hero.name), power))
            time.sleep(1)
            dragonhp = dragon.damage(power)
            if dragonhp <= 0:
                jewel = dragon.giveJewel()
                item = hero.item_list()
                if jewel == 0:
                    time.sleep(1)
                    print("-------------------------------")
                    print("[★ 보너스 체력이 추가됐습니다!(+20)]")
                    if hero.hp < 100:
                        print("체력: %d -> %d" % (self.player.hp, self.player.hp + 20))
                        self.player.hp += 20
                    else:
                        print("체력이 이미 꽉 찼습니다(100 -> 100)")
                if item == 1:
                    time.sleep(1)
                    print("-------------------------------")
                    print("[★ '날카로운 칼' 을 주웠습니다!]")
                    print("[공격 데미지 범위가 늘어났습니다(+10)]")
                    print("데미지 범위: (%d ~ %d) -> (%d ~ %d)" % (hero.min, hero.mp, hero.min + 10, hero.mp))
                    self.player.min += 10
                elif item == 2:
                    time.sleep(1)
                    print("-------------------------------")
                    print("[★ '전사의 물약' 을 주웠습니다!]")
                    print("[물약을 마시자마자 신비로운 빛이 몸을 감싸며 체력이 끝까지 채워졌습니다]")
                    if hero.hp < 100:
                        print("체력: %d -> 100" % hero.hp)
                        hero.hp = 100
                    else:
                        print("체력이 이미 꽉 찼습니다(100 -> 100)")

                elif item == 3:
                    time.sleep(1)
                    print("-------------------------------")
                    print("[★ '에메랄드 방패'를 주웠습니다!]")
                    print("[적의 공격력이 약간 감소합니다]")
                    dpower -= 10
                break
            dpower = dragon.attackHero()
            print("!!용이 %d 의 데미지로 공격했다!!" % dpower)
            time.sleep(1)
            herohp = hero.damage(dpower)
            if herohp <= 0:
                return
        print("-------------------------------")
        self.fight()

ground = Colosseum()
ground.makePlayer()
ground.fight()