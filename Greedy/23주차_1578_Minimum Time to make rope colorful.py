
    
def minCost(colors, neededTime):
        """
        :type colors: str
        :type neededTime: List[int]
        :rtype: int
        """
        output = 0
        temp = 0
        for i in range(1, len(colors)):
            if colors[temp] == colors[i]:
                if (neededTime[i] < neededTime[temp]):
                    output += neededTime[i]
                else:
                    output += neededTime[temp]
                    temp = i
                continue
            else:
                temp = i
        return output

print(minCost("aaabbbabbbb", [3,5,10,7,5,3,5,5,4,8,1]))