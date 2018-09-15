class D_Weather:

    def __init__(self, day, min = 0, max = 0):
        self.day = day
        self.min = min
        self.max = max

    def __str__(self):
        return str(self.day) + " " + str(self.min) + " " + str(self.max)

    def checkMin(self,other):
        if self.min < other.min:
            return self
        else:
            return other

records = [D_Weather(1, -5, 4),
           D_Weather(2, -4, 2),
           D_Weather(3, -7, 0),
           D_Weather(4, -9, -1),
           D_Weather(5, -6, 2)
           ]

cold_day = D_Weather(0, 0, 0)

for x in records:
    #제일 추운 날한테 다른 날과 비교시킴
    cold_day = cold_day.checkMin(x)

print(cold_day)