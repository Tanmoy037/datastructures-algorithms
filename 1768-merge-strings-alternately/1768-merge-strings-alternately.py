class Solution:
    def mergeAlternately(self, w1: str, w2: str) -> str:
        result = []
        i = 0
        j = 0

        while i < len(w1) and j < len(w2):
            result.append(w1[i])
            result.append(w2[j])
            i += 1
            j += 1

        # Add the remaining characters from w1 or w2 if any
        result.extend(w1[i:])
        result.extend(w2[j:])

        return "".join(result)

                


