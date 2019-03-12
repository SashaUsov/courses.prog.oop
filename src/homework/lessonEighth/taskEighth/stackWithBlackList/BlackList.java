package homework.lessonEighth.taskEighth.stackWithBlackList;

import homework.lessonEighth.taskEighth.stackWithBlackList.exc.BlackListOverflowException;

import java.util.stream.IntStream;

public class BlackList {
    private Class[] blackList = new Class[5];

    public BlackList() {
    }

    public BlackList(Class[] blackList) {
        this.blackList = blackList;
    }

    public Class[] getBlackList() {
        return blackList;
    }

    public void setBlackList(Class[] blackList) {
        this.blackList = blackList;
    }

    /*
        * Adding an object to the blacklist
        * */
    public void addToBlackList(Object o) throws BlackListOverflowException {
        IntStream.range(0, blackList.length)
                .filter(idx -> blackList[idx] == null)
                .boxed()
                .findFirst()
                .map(idx -> blackList[idx] = o.getClass())
                .orElseThrow(BlackListOverflowException::new);
    }

    /*
    * Check object for entry into the blacklist
    * */
    public boolean inBlackList(Object o) {
        for (Class inBlackList : blackList) {
            if (inBlackList != null) {
                if (o.getClass() == inBlackList) {
                    return false;
                }
            }
        }
        return true;
    }
}
