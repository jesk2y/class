
class Dragon:


    def __init__(self):
        self.hungry = True

    def makeFire(self):
        if self.hungry == True:
            print("I'm hungry...")
            return
        print("~~~~~~~~~~~~~~~~~~~~~~")
        print("~~~~~~~~~~~~~~~~~~~~~~")
        self.hungry = True

    def eat(self):
        if self.hungry == False:
            print('Im Full')
            return
        print("yammy yammy")
        self.hungry = False
        print("Thanks!")


dragon = Dragon()

dragon.makeFire()
dragon.eat()
dragon.makeFire()
dragon.makeFire()