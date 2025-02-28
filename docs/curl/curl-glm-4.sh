curl -X POST \
        -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsInNpZ25fdHlwZSI6IlNJR04ifQ.eyJhcGlfa2V5IjoiOGQ4MmFhMWRjOTNkNDNkNGE5ZDA0NGE0NTE2MWI3ZGUiLCJleHAiOjE3NDA3NDU2MDk1ODksInRpbWVzdGFtcCI6MTc0MDc0MzgwOTU5NH0.YWeMAu_6PGg1m0I7bfdzNxBz9jCkLZncddCWLrbr03c
" \
        -H "Content-Type: application/json" \
        -H "User-Agent: Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)" \
        -d '{
          "model":"glm-4",
          "stream": "true",
          "messages": [
              {
                  "role": "user",
                  "content": "1+1"
              }
          ]
        }' \
  https://open.bigmodel.cn/api/paas/v4/chat/completions