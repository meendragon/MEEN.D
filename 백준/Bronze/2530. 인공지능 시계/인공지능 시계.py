# 현재 시각 입력
A, B, C = map(int, input().split())

# 요리 시간 입력
D = int(input())

# 모든 시간을 초로 변환하여 더함
total_seconds = (A * 3600) + (B * 60) + C + D

# 완료 시각 계산
end_hour = (total_seconds // 3600) % 24
end_minute = (total_seconds % 3600) // 60
end_second = total_seconds % 60

# 결과 출력
print(end_hour, end_minute, end_second)