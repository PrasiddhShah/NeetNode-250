class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack =[]

        for asteroid in asteroids:
            alive = True
            while stack and asteroid < 0 < stack[-1]:
                if abs(asteroid) > stack[-1]:
                    stack.pop()
                elif abs(asteroid) == stack[-1]:
                    stack.pop()
                    alive = False
                    break
                else:
                    alive = False
                    break
            if alive:
                stack.append(asteroid)
        return stack