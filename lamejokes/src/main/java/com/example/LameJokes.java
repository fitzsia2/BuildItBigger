package com.example;


public class LameJokes {
    private static String[] m_lsJokes = {
            "Team work is important; it helps to put the blame on someone else.",
            "Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water.",
            "You know that tingly little feeling you get when you like someone? That's your common sense leaving your body.",
            "Before I criticize a man, I like to walk a mile in his shoes. That way, when I do criticize him, I'm a mile away and I have his shoes.",
            "Keep the dream alive: Hit the snooze button.",
            "When my boss asked me who is the stupid one, me or him? I told him everyone knows he doesn't hire stupid people.",
            "Feeling pretty proud of myself. The Sesame Street puzzle I bought said 3-5 years, but I finished it in 18 months.",
            "Hospitality: making your guests feel like they're at home, even if you wish they were.",
            "Just read that 4,153,237 people got married last year, not to cause any trouble but shouldn't that be an even number?",
            "What do you call an alligator wearing a vest? An investigator",
    };

    public static String getRandomJoke() {
        int index = ((int) Math.floor(Math.random() * m_lsJokes.length));

        return m_lsJokes[index];
    }

}
