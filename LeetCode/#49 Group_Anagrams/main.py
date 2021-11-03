import collections
import heapq
import functools
import itertools
import re
import sys
import math
import bisect
from typing import *

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = collections.defaultdict(list)

        for word in strs:
            anagrams[''.join(sorted(word))].append(word)
        return sorted(list(anagrams.values()), key=len)

solution = Solution()
print(solution.groupAnagrams(strs = ["eat","tea","tan","ate","nat","bat"]))