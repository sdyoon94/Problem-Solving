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
    def isPalindrome(self, s: str) -> bool:
        # 문자 필터링 : 리스트 사용
        # strs = []
        # for char in s:
        #     if char.isalnum():
        #         strs.append(char.lower())

        # 문자 필터링 2 : 데크 사용
        # strs: Deque = collections.deque()
        # for char in s:
        #     if char.isalnum():
        #         strs.append(char.lower())

        # 문자 필터링 3 : 정규표현식
        s = s.lower()
        s = re.sub('[^a-z0-9]', '', s)
        
        # 팰린드럼 판별
        # while len(strs) > 1:
        #     if strs.popleft() != strs.pop():
        #         return False
        
        # return True

        # 슬라이싱
        return s == s[::-1]