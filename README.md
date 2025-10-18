# 🐉 RocoKingdom 洛克王国（Java Console Edition）

A **console-based pet battle game** inspired by *Roco Kingdom*, built entirely in **Java 17**.  
一款以《洛克王国》为灵感、使用 **Java 17** 构建的 **控制台宠物对战游戏**。  
Features ASCII art, background music, and turn-based combat with elemental advantages (🔥 Fire, 💧 Water, 🌿 Grass).  
支持 ASCII 图形渲染、背景音乐、属性克制的回合制战斗系统。

---

## 🕹️ Features | 功能特色

- 🎨 **ASCII Art Rendering** — Unique art for each creature with color effects  
  **ASCII 艺术渲染**：为每个精灵绘制独特的彩色像素图案  
- 🎵 **Background & Battle Music** — Dynamic BGM using `javax.sound.sampled.Clip`  
  **动态音乐系统**：探索与战斗音乐自动切换  
- ⚔️ **Turn-based Combat System** — Accuracy, attributes, and random factor  
  **回合制战斗系统**：包含命中率、克制与随机伤害修正  
- 💾 **Pet Management** — Player bag & warehouse auto-updates  
  **宠物仓库系统**：战斗结束后自动更新背包  
- 🌱 **Fully Object-Oriented Design** — Modular and extensible  
  **完全面向对象架构**：便于扩展与维护

---

## 🧩 Project Structure | 项目结构

```
RocoKingdom/
├── App.java                # Main entry point / 主程序入口
├── config/
│   ├── AllPets.java        # Defines all pets & skills / 全宠物技能表
│   ├── Data.java           # Global game data / 游戏数据中心
├── pojo/
│   ├── Pet.java            # Pet attributes / 宠物实体类
│   ├── Skill.java          # Skill model / 技能实体类
├── service/
│   ├── MusicManager.java   # Music playback / 音乐管理
│   ├── Service.java        # Battle logic / 战斗核心逻辑
├── view/
│   ├── AsciiArt.java       # Enemy intro art / 敌方出场图
│   ├── View.java           # UI interaction / 控制台界面
├── bgm.wav                 # Background music / 背景音乐
├── battle.wav              # Battle music / 战斗音乐
└── README.md
```

---

## 🚀 How to Run | 运行方法

### Requirements | 环境要求
- **Java 17+**
- (Optional) IntelliJ IDEA / VS Code Terminal

### Run from Terminal | 终端运行
```bash
javac App.java
java App
```
You’ll hear background music and see colored ASCII art animations.  
运行后将自动播放 BGM 并展示彩色 ASCII 精灵图。

---

## 📸 Preview | 游戏截图

```
────────────────────────
      Enemy · Fire Dragon
────────────────────────
Enemy Fire-type pet appeared!
It let out a fierce roar...
The battle begins!

🟥🟧🟨🟩🟦
```

Victory screen:
```
V I C T O R Y !
You have defeated all wild creatures — congratulations, you cleared the game!
```

---

## 🧠 Gameplay Mechanics | 战斗机制

| Type Advantage | Effect | 属性克制 | 效果 |
|----------------|---------|-----------|------|
| 🔥 Fire → 🌿 Grass | 1.25× Damage | 火 → 草 | 伤害提升 25% |
| 🌿 Grass → 💧 Water | 1.25× Damage | 草 → 水 | 伤害提升 25% |
| 💧 Water → 🔥 Fire | 1.25× Damage | 水 → 火 | 伤害提升 25% |
| Opposite | 0.75× Damage | 被克制 | 伤害降低 25% |

Each skill has its own hit rate and damage coefficient.  
每个技能都带有独立命中率与威力系数。

---

## 🎵 Music System | 音乐系统

| File | Description | 文件 | 说明 |
|-------|--------------|------|------|
| `bgm.wav` | Background exploration music | 背景音乐 | 游戏主界面播放 |
| `battle.wav` | Battle theme | 战斗音乐 | 战斗时自动切换 |

---

## 🧰 Tech Stack | 技术栈

- **Language:** Java 17  
- **Audio:** `javax.sound.sampled`  
- **Paradigm:** Object-Oriented Programming  
- **UI:** Console (ANSI color)  

---

## 🌟 Future Plans | 未来计划

- 🧍 Player naming & save system / 玩家命名与存档系统  
- 🪄 Skill effects with animations / 技能特效动画  
- 🖼️ GUI version (JavaFX/Swing) / 图形化版本  
- 🧬 More pets & storyline / 更多宠物与剧情模式  

---

## 🧑‍💻 Author | 作者

**Johnny Wang (johnnywang-byte)**  
📍 York University · Computer Science  
🇨🇦 Based in Toronto, Canada  
