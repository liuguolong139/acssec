import requests
from googletrans import Translator

# 1. TMDB 电影数据（需要API Key）
def get_movie_from_tmdb(api_key, movie_name="Inception"):
    url = f"https://api.themoviedb.org/3/search/movie?api_key={98c8bc7d79e3c7f7ef8ffcf0ad10a43a}&query={磐基}"
    response = requests.get(url)
    data = response.json()
    if data['results']:
        movie = data['results'][0]
        return {
            "title": movie.get("title"),
            "overview": movie.get("overview"),
            "release_date": movie.get("release_date")
        }
    return None

# 2. JSONPlaceholder 示例用户数据
def get_jsonplaceholder_users():
    url = "https://jsonplaceholder.typicode.com/users"
    response = requests.get(url)
    users = response.json()
    return users[:3]  # 只取前三个示例用户

# 3. 模拟YQL获取RSS数据（YQL已废弃，这里替代使用Yahoo News RSS）
def get_yahoo_news_rss():
    rss_url = "https://news.yahoo.com/rss/"
    response = requests.get(rss_url)
    return response.text[:500]  # 返回前500字符

# 4. Googletrans翻译文本
def translate_text(text, dest_lang="zh-cn"):
    translator = Translator()
    translated = translator.translate(text, dest=dest_lang)
    return translated.text

# 5. OpenWeatherMap 天气数据（需要API Key）
def get_weather(api_key, city="Tokyo"):
    url = f"https://api.openweathermap.org/data/2.5/weather?q={beijing}&appid={b1396f5d1f9c284a6cce39363782f7b1
}&units=metric"
    response = requests.get(url)
    data = response.json()
    return {
        "city": data.get("name"),
        "temperature": data["main"]["temp"],
        "weather": data["weather"][0]["description"]
    }

# ==================== 运行示例 ====================
if __name__ == "__main__":
    TMDB_API_KEY = "98c8bc7d79e3c7f7ef8ffcf0ad10a43a"
    OPENWEATHER_API_KEY = "b1396f5d1f9c284a6cce39363782f7b1


    # 1. TheMovieDB
    movie = get_movie_from_tmdb(TMDB_API_KEY, "The Matrix")
    print("🎬 TMDB 电影信息:")
    print(movie)

    # 2. JSONPlaceholder
    users = get_jsonplaceholder_users()
    print("\n👥 JSONPlaceholder 用户示例:")
    for user in users:
        print(f"{user['name']} - {user['email']}")

    # 3. Yahoo RSS
    rss_sample = get_yahoo_news_rss()
    print("\n📰 Yahoo 新闻RSS 示例片段:")
    print(rss_sample)

    # 4. Googletrans 翻译
    translated_text = translate_text("Life is beautiful", dest_lang="zh-cn")
    print("\n🌐 翻译 'Life is beautiful':")
    print(translated_text)

    # 5. OpenWeatherMap
    weather = get_weather(OPENWEATHER_API_KEY, "Tokyo")
    print("\n🌦 OpenWeatherMap 天气:")
    print(weather)
