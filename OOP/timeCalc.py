import math
class H_Needle:
    def __init__(self, value = 0):
        self.value = value
        while (self.value >= 12):
            self.value -= 12

    def getDegree(self, min_value):
        while (min_value >= 60):
            min_value -= 60
        result = (360 / 12) * self.value
        result += (30 / 60) * min_value
        return result

class M_Needle:
    def __init__(self,value = 0):
        self.min = value
    def getDegree(self):
        return self.min * (360/60)


class Clock:
    def __init__(self,h_value, m_value):
        self.hour = H_Needle(h_value)
        self.min = M_Needle(m_value)
        self.m_value = m_value

    def calc(self):
        h_deg = self.hour.getDegree(self.m_value)
        m_deg = self.min.getDegree()
        result = math.fabs(h_deg - m_deg)
        if result >= 180:
            result -= 180
        return result

c = Clock(9,10)
print(c.calc())