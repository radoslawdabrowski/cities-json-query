package pl.radoslawdabrowski.cities.citiesjsonquery.handlers;

import java.util.List;

public class PageableHandler<T> {

    public static final int DEFAULT_PAGE_SIZE = 10;

    private static final int PAGE_WINDOW = 10;

    private List<T> list;

    private int pageSize = DEFAULT_PAGE_SIZE;

    private int page;

    private int startingIndex;

    private int endingIndex;

    private int maxPages;

    public PageableHandler(List<T> list) {
        this.list = list;
        this.page = 1;
        this.maxPages = 1;

        calculatePages();
    }

    private void calculatePages() {
        if (pageSize > 0) {
            if (list.size() % pageSize == 0) {
                maxPages = list.size() / pageSize;
            } else {
                maxPages = (list.size() / pageSize) + 1;
            }
        }
    }

    public List<T> getList() {
        return this.list;
    }

    public List<T> getListForPage() {
        return list.subList(startingIndex, endingIndex);
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        calculatePages();
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int p) {
        if (p >= maxPages) {
            this.page = maxPages;
        } else if (p <= 1) {
            this.page = 1;
        } else {
            this.page = p;
        }

        startingIndex = pageSize * (page-1);
        if (startingIndex < 0) {
            startingIndex = 0;
        }
        endingIndex = startingIndex + pageSize;
        if (endingIndex > list.size()) {
            endingIndex = list.size();
        }
    }

    public int getMaxPages() {
        return this.maxPages;
    }

    public int getPreviousPage() {
        if (page > 1) {
            return page-1;
        } else {
            return 0;
        }
    }

    public int getNextPage() {
        if (page < maxPages) {
            return page+1;
        } else {
            return 0;
        }
    }

    public int getMinPageRange() {
        if (getPage() > PAGE_WINDOW) {
            return getPage() - PAGE_WINDOW;
        } else {
            return 1;
        }
    }

    public int getMaxPageRange() {
        if (getPage() < (getMaxPages() - PAGE_WINDOW)) {
            return getPage() + PAGE_WINDOW;
        } else {
            return getMaxPages();
        }
    }
}
