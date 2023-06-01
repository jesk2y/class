import math
class Circle:

    def __init__(self, radius):# 반지름값 반드시 구하기
        self.radius = radius

    def getArea(self):
        return math.pow(self.radius, 2) * math.pi



c1 = Circle(10)
c2 = Circle(5)

print(c1.getArea())
print(c2.getArea())
