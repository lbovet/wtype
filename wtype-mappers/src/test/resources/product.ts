interface Dimension {
    length: number;
    width: number;
    height: number;
}

interface Product {

    /**
     * The unique identifier for a product.
     */
    id: number;

    /**
     * Name of the product
     */
    name: string;

    price: number;

    tags: string[];

    dimension: Dimension;
}
