import random
class item:
    def __init__(self,str):
        self.str = str
    def __str__(self):
        return 'VALUE: ' + self.str
"""
class Box:

    def selectOne(self):
        random.shuffle(item_list)
        return item_list.pop()

item_list = [item('0')] * 4
item_list.append(item('X'))
box = Box()
"""
class Box:
    def __init__(self,items):
        self.items = items
        random.shuffle(self.items)

    def selectOne(self):
        return self.items.pop()

item_list = [item('0')] * 4
item_list.append(item('X'))
box = Box(item_list)

for i in range(5):
    print(box.selectOne())