class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        boat = 0
        low = 0
        high = len(people)-1
        while low <= high:
            if people[high]+people[low] <= limit:
                low+=1
            high-=1
            boat+=1
        boat
        return boat