import sys
import re
import os
from urllib import request

if __name__ == '__main__' and len(sys.argv) == 2:
    req = request.Request(sys.argv[1], headers={'User-Agent': 'Mozilla/5.0', 'cookie': "__cfduid=def74ceb75ddf5d26d38d1bd793e6033e1506981626; __atuvc=26%7C45%2C0%7C46%2C0%7C47%2C0%7C48%2C2%7C49; _ga=GA1.2.121104069.1503945044; _gid=GA1.2.812613237.1521691638; csrftoken=fDA3pzzkdM2qzE4kMQ9kNBOsA8AnUOACUGxJZXYkSOk08bPLbNR57XHi9PTIJsiO; LEETCODE_SESSION=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkZlbmdzaHVhbmdMaSIsInVzZXJfc2x1ZyI6ImZlbmdzaHVhbmdsaSIsIl9hdXRoX3VzZXJfaWQiOiIyMDMxMDYiLCJSRU1PVEVfQUREUiI6IjY1Ljc4LjE2LjI5IiwidGltZXN0YW1wIjoiMjAxOC0wMy0yMiAwNDowODowNi4zMTk3MjErMDA6MDAiLCJfYXV0aF91c2VyX2JhY2tlbmQiOiJhbGxhdXRoLmFjY291bnQuYXV0aF9iYWNrZW5kcy5BdXRoZW50aWNhdGlvbkJhY2tlbmQiLCJpZCI6MjAzMTA2LCJhdmF0YXIiOiJodHRwczovL3d3dy5ncmF2YXRhci5jb20vYXZhdGFyL2ExNDE3ZDZlMzIwNTYzZmQ3OTI2OTFhZTg1NmY1Yzc2LnBuZz9zPTIwMCIsIl9zZXNzaW9uX2V4cGlyeSI6MCwiX2F1dGhfdXNlcl9oYXNoIjoiMmFmN2U0OGE5NDZmYzAyMGZhNjFhYmZlNTJlYmQxMDAyMTdiZTZiZSIsImVtYWlsIjoiZmVuZ3NodWFuZzExMDJAZ21haWwuY29tIiwiSURFTlRJVFkiOiJlNzFjODJiZTg0NWJkMzZjZWNiYjU4Mzk5NDFiYTY0ZSJ9.-dZzmRkWgYPJP6U-NU06cNkSIA3zbj3-D_U8NaVZiN0"})
    html = request.urlopen(req).read().decode("utf-8")
    m = re.search(r"<title>(.*) - LeetCode</title>", html, re.S)
    m_id = re.search(r"questionId: '(\d+)'", html, re.S)
    if m and m_id:
        filename = '_%s_%s.cpp' % (m_id.group(1), m.group(1).strip().replace(' ', '_'))
        print(m.group(1))
        if os.path.isfile(filename):
            print("File exists")
            exit(0)
        open(filename, 'w').close()
    else:
        print(html)
        print("Regex match failed")
